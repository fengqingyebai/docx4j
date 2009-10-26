/*
 *  Copyright 2009, Plutext Pty Ltd.
 *   
 *  This file is part of docx4j.

    docx4j is licensed under the Apache License, Version 2.0 (the "License"); 
    you may not use this file except in compliance with the License. 

    You may obtain a copy of the License at 

        http://www.apache.org/licenses/LICENSE-2.0 

    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, 
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    See the License for the specific language governing permissions and 
    limitations under the License.

 */
package org.docx4j.model.properties;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.docx4j.XmlUtils;
import org.docx4j.model.properties.paragraph.Indent;
import org.docx4j.model.properties.paragraph.Justification;
import org.docx4j.model.properties.paragraph.KeepNext;
import org.docx4j.model.properties.paragraph.PageBreakBefore;
import org.docx4j.model.properties.paragraph.TextAlignmentVertical;
import org.docx4j.model.properties.run.Bold;
import org.docx4j.model.properties.run.Font;
import org.docx4j.model.properties.run.FontColor;
import org.docx4j.model.properties.run.FontSize;
import org.docx4j.model.properties.run.Italics;
import org.docx4j.model.properties.run.Strike;
import org.docx4j.model.properties.run.Underline;
import org.docx4j.model.properties.table.BorderBottom;
import org.docx4j.model.properties.table.BorderLeft;
import org.docx4j.model.properties.table.BorderRight;
import org.docx4j.model.properties.table.BorderTop;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.CTTblCellMar;
import org.docx4j.wml.CTTblPrBase;
import org.docx4j.wml.CTTblStylePr;
import org.docx4j.wml.PPr;
import org.docx4j.wml.RPr;
import org.docx4j.wml.TblBorders;
import org.docx4j.wml.TblPr;
import org.docx4j.wml.TcPr;
import org.docx4j.wml.TrPr;
import org.w3c.dom.css.CSSValue;

public class PropertyFactory {
	
	/* We could have separate factories for paragraph
	 * and run properties, but having a single factory
	 * is better, since it means we don't need to know
	 * whether the property for which we are creating
	 * a Property object is paragraph or run level.
	 */
	
	protected static Logger log = Logger.getLogger(PropertyFactory.class);
	
	public static List<Property> createProperties(CTTblPrBase  tblPr) {
		
		List<Property> properties = new ArrayList<Property>();
		
		if (tblPr.getTblInd()!=null ) 
			properties.add(new org.docx4j.model.properties.table.Indent(tblPr.getTblInd()) );
		
		if (tblPr.getTblBorders()!=null) {
			TblBorders tblBorders = tblPr.getTblBorders();
			if (tblBorders.getTop()!=null) 
				properties.add(new BorderTop(tblBorders.getTop()) );				
			if (tblBorders.getBottom()!=null) 
				properties.add(new BorderBottom(tblBorders.getBottom()) );				
			if (tblBorders.getLeft()!=null) 
				properties.add(new BorderLeft(tblBorders.getLeft()) );				
			if (tblBorders.getRight()!=null) 
				properties.add(new BorderRight(tblBorders.getRight()) );	
			// TODO
//			if (tblBorders.getInsideH()!=null) 
//				properties.add(new BorderRight(tblBorders.getRight()) );				
//			if (tblBorders.getInsideV()!=null) 
//				properties.add(new BorderRight(tblBorders.getRight()) );				
		}
		
//		if (tblPr.getTblCellMar()!=null) {
//			CTTblCellMar cellMar = tblPr.getTblCellMar();
//			if (cellMar.getTop()!=null) {
//			}
//			if (cellMar.getBottom()!=null) {
//			}
//			if (cellMar.getLeft()!=null) {
//			}
//			if (cellMar.getRight()!=null) {
//			}
//		}
		
		return properties;		
	}

	public static List<Property> createProperties(List<CTTblStylePr> tblStylePrList) {
		
		List<Property> properties = new ArrayList<Property>();
		log.warn("TODO - implement!");
		return properties;		
	}

	public static List<Property> createProperties(TrPr trPr) {
		
		List<Property> properties = new ArrayList<Property>();
		log.warn("TODO - implement!");
		return properties;		
	}

	public static List<Property> createProperties(TcPr tcPr) {
		
		List<Property> properties = new ArrayList<Property>();
		log.warn("TODO - implement!");
		return properties;		
	}

	public static List<Property> createProperties(WordprocessingMLPackage wmlPackage, RPr rPr) {
		
		List<Property> properties = new ArrayList<Property>();
		
		if (rPr.getB() != null)
			properties.add(new Bold(rPr.getB()) );
//		if (rPr.getBCs() != null)
//			dest.setBCs(rPr.getBCs());
//		if (rPr.getBdr() != null)
//			dest.setBdr(rPr.getBdr());
//		if (rPr.getCaps() != null)
//			dest.setCaps(rPr.getCaps());
		if (rPr.getColor() != null)
			properties.add(new FontColor(rPr.getColor()) );
//		if (rPr.getCs() != null)
//			dest.setCs(rPr.getCs());
//		if (rPr.getDstrike() != null)
//			dest.setDstrike(rPr.getDstrike());
//		if (rPr.getEastAsianLayout() != null)
//			dest.setEastAsianLayout(rPr.getEastAsianLayout());
//		if (rPr.getEffect() != null)
//			dest.setEffect(rPr.getEffect());
//		if (rPr.getEm() != null)
//			dest.setEm(rPr.getEm());
//		if (rPr.getEmboss() != null)
//			dest.setEmboss(rPr.getEmboss());
//		if (rPr.getFitText() != null)
//			dest.setFitText(rPr.getFitText());
//		if (rPr.getHighlight() != null)
//			dest.setHighlight(rPr.getHighlight());
		if (rPr.getI() != null)
			properties.add(new Italics(rPr.getI()) );
//		if (rPr.getICs() != null)
//			dest.setICs(rPr.getICs());
//		if (rPr.getImprint() != null)
//			dest.setImprint(rPr.getImprint());
//		if (rPr.getKern() != null)
//			dest.setKern(rPr.getKern());
//		if (rPr.getLang() != null)
//			dest.setLang(rPr.getLang());
//		if (rPr.getNoProof() != null)
//			dest.setNoProof(rPr.getNoProof());
//		if (rPr.getOMath() != null)
//			dest.setOMath(rPr.getOMath());
//		if (rPr.getOutline() != null)
//			dest.setOutline(rPr.getOutline());
//		if (rPr.getPosition() != null)
//			dest.setPosition(rPr.getPosition());
		if (rPr.getRFonts() != null)
			properties.add(new Font(wmlPackage, rPr.getRFonts() ) );
//		if (rPr.getRPrChange() != null)
//			dest.setRPrChange(rPr.getRPrChange());
//		if (rPr.getRStyle() != null)
//			dest.setRStyle(rPr.getRStyle());
//		if (rPr.getRtl() != null)
//			dest.setRtl(rPr.getRtl());
//		if (rPr.getShadow() != null)
//			dest.setShadow(rPr.getShadow());
//		if (rPr.getShd() != null)
//			dest.setShd(rPr.getShd());
//		if (rPr.getSmallCaps() != null)
//			dest.setSmallCaps(rPr.getSmallCaps());
//		if (rPr.getSnapToGrid() != null)
//			dest.setSnapToGrid(rPr.getSnapToGrid());
//		if (rPr.getSpacing() != null)
//			dest.setSpacing(rPr.getSpacing());
//		if (rPr.getSpecVanish() != null)
//			dest.setSpecVanish(rPr.getSpecVanish());
		if (rPr.getStrike() != null)
			properties.add(new Strike(rPr.getStrike() ) );
		if (rPr.getSz() != null)
			properties.add(new FontSize(rPr.getSz() ) );
//		if (rPr.getSzCs() != null)
//			dest.setSzCs(rPr.getSzCs());
		if (rPr.getU() != null)
			properties.add(new Underline(rPr.getU() ) );
//		if (rPr.getVanish() != null)
//			dest.setVanish(rPr.getVanish());
//		if (rPr.getVertAlign() != null)
//			dest.setVertAlign(rPr.getVertAlign());
//		if (rPr.getW() != null)
//			dest.setW(rPr.getW());
//		if (rPr.getWebHidden() != null)
//			dest.setWebHidden(rPr.getWebHidden());
		
		return properties;		
	}
	

	public static List<Property> createProperties(PPr pPr) {
		
		List<Property> properties = new ArrayList<Property>();
		
//		if (pPr.getAdjustRightInd() != null)
//			dest.setAdjustRightInd(pPr.getAdjustRightInd());
//		if (pPr.getAutoSpaceDE() != null)
//			dest.setAutoSpaceDE(pPr.getAutoSpaceDE());
//		if (pPr.getAutoSpaceDN() != null)
//			dest.setAutoSpaceDN(pPr.getAutoSpaceDN());
//		if (pPr.getBidi() != null)
//			dest.setBidi(pPr.getBidi());
//		if (pPr.getCnfStyle() != null)
//			dest.setCnfStyle(pPr.getCnfStyle());
//		if (pPr.getContextualSpacing() != null)
//			dest.setContextualSpacing(pPr.getContextualSpacing());
//		if (pPr.getDivId() != null)
//			dest.setDivId(pPr.getDivId());
//		if (pPr.getFramePr() != null)
//			dest.setFramePr(pPr.getFramePr());
		if (pPr.getInd() != null)
			properties.add(new Indent(pPr.getInd()));
		if (pPr.getJc() != null)
			properties.add(new Justification(pPr.getJc()));
//		if (pPr.getKeepLines() != null)
//			dest.setKeepLines(pPr.getKeepLines());
		if (pPr.getKeepNext() != null)
			properties.add(new KeepNext(pPr.getKeepNext()));
//		if (pPr.getKinsoku() != null)
//			dest.setKinsoku(pPr.getKinsoku());
//		if (pPr.getMirrorIndents() != null)
//			dest.setMirrorIndents(pPr.getMirrorIndents());
//		if (pPr.getNumPr() != null)
//			dest.setNumPr(pPr.getNumPr());
//		if (pPr.getOutlineLvl() != null)
//			dest.setOutlineLvl(pPr.getOutlineLvl());
//		if (pPr.getOverflowPunct() != null)
//			dest.setOverflowPunct(pPr.getOverflowPunct());
		if (pPr.getPageBreakBefore() != null)
			properties.add(new PageBreakBefore(pPr.getPageBreakBefore()));
//		if (pPr.getPBdr() != null)
//			dest.setPBdr(pPr.getPBdr());
//		if (pPr.getPPrChange() != null)
//			dest.setPPrChange(pPr.getPPrChange());
//		if (pPr.getPStyle() != null)
//			dest.setPStyle(pPr.getPStyle());
//		if (pPr.getSectPr() != null)
//			dest.setSectPr(pPr.getSectPr());
//		if (pPr.getShd() != null)
//			dest.setShd(pPr.getShd());
//		if (pPr.getSnapToGrid() != null)
//			dest.setSnapToGrid(pPr.getSnapToGrid());
//		if (pPr.getSpacing() != null)
//			dest.setSpacing(pPr.getSpacing());
//		if (pPr.getSuppressAutoHyphens() != null)
//			dest.setSuppressAutoHyphens(pPr.getSuppressAutoHyphens());
//		if (pPr.getSuppressLineNumbers() != null)
//			dest.setSuppressLineNumbers(pPr.getSuppressLineNumbers());
//		if (pPr.getSuppressOverlap() != null)
//			dest.setSuppressOverlap(pPr.getSuppressOverlap());
//		if (pPr.getTabs() != null)
//			dest.setTabs(pPr.getTabs());
		if (pPr.getTextAlignment() != null)
			properties.add(new TextAlignmentVertical(pPr.getTextAlignment()));
//		if (pPr.getTextboxTightWrap() != null)
//			dest.setTextboxTightWrap(pPr.getTextboxTightWrap());
//		if (pPr.getTextDirection() != null)
//			dest.setTextDirection(pPr.getTextDirection());
//		if (pPr.getTopLinePunct() != null)
//			dest.setTopLinePunct(pPr.getTopLinePunct());
//		if (pPr.getWidowControl() != null)
//			dest.setWidowControl(pPr.getWidowControl());
//		if (pPr.getWordWrap() != null)
//			dest.setWordWrap(pPr.getWordWrap());
		
		return properties;		
	}
	
	
	public static Property createPropertyFromCssName(String name, CSSValue value) {
		
		// Run properties
		if (name.equals(Font.CSS_NAME )) {
			// font-family
			return new Font(value);
		} else if (name.equals(Bold.CSS_NAME )) {
			// font-weight
			return new Bold(value);
		} else if (name.equals(Italics.CSS_NAME )) {
			// font-style
			return new Italics(value);
		} else if (name.equals("text-decoration")) {
			if (value.getCssText().toLowerCase().equals("line-through")) {
				return new Strike(value);
			} else if (value.getCssText().toLowerCase().equals("underline")) {
				return new Underline(value);
			} else {
				log.error("What to do for " + name + ":" + value.getCssText());
			}
		} else if (name.equals(FontColor.CSS_NAME )) {
			// color
			return new FontColor(value);
		} else if (name.equals(FontSize.CSS_NAME )) {
			// font-size
			return new FontSize(value);
		} 
		
		// Paragraph properties
		if (name.equals(Indent.CSS_NAME )) {
			// left
			return new Indent(value);
		} else if (name.equals(Justification.CSS_NAME )) {
			// text-align
			return new Justification(value);
		} else if (name.equals(KeepNext.CSS_NAME )) {
			// page-break-after
			return new KeepNext(value);
		} else if (name.equals(PageBreakBefore.CSS_NAME)) {
			// page-break-before
			return new PageBreakBefore(value);
		} else if (name.equals(TextAlignmentVertical.CSS_NAME )) {
			// vertical-align
			return new TextAlignmentVertical(value);
		}		
		
		log.warn("How to handle: " + name + "?");
		return null;
	}
	
	
	
	

}
